FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://0001-Reload-the-running-firewall-without-writing-configuration.patch \
    file://dds_enable.sh \
    file://dds_disable.sh \
    file://oasis-dds \
    file://oasis-dds-after.init \
    file://oasis-dds.service \
    file://oasis-dds.socket \
    file://oasis-sshguard-before.init \
"

RDEPENDS:${PN} += "iproute2-ip"
SYSTEMD_SERVICE:${PN} += "oasis-dds.service oasis-dds.socket"

do_install:append() {
    install -m 0755 "${UNPACKDIR}/dds_enable.sh" "${UNPACKDIR}/dds_disable.sh" "${D}${sbindir}/"
    install -m 0755 "${UNPACKDIR}/oasis-dds" "${D}${nonarch_base_libdir}/ufw/"
    install -m 0755 "${UNPACKDIR}/oasis-dds-after.init" "${D}${sysconfdir}/ufw/after.init"
    install -m 0644 "${UNPACKDIR}/oasis-dds.service" "${UNPACKDIR}/oasis-dds.socket" "${D}${systemd_system_unitdir}/"

    # A chain declaration in iptables-restore flushes active sshguard bans
    # even with --noflush. Create Curie's chain only when it does not exist.
    if grep -q '^:sshguard ' "${D}${sysconfdir}/ufw/before.rules"; then
        sed -i '/^:sshguard /d' "${D}${sysconfdir}/ufw/before.rules"
        install -m 0755 "${UNPACKDIR}/oasis-sshguard-before.init" "${D}${sysconfdir}/ufw/before.init"
    fi

    # UFW appends its jump to ufw-user-input after loading before.rules.
    cat >> "${D}${sysconfdir}/ufw/before.rules" <<'RULES'
*filter
:oasis-dds - [0:0]
-A ufw-before-input -p udp --dport 7400:7649 -j oasis-dds
COMMIT
RULES
}
