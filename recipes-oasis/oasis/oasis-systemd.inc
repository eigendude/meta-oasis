# Keep the service definition in OASIS; only target-specific settings live here.
inherit systemd

SRC_URI:append = " file://10-yocto.conf"

SYSTEMD_SERVICE:${PN} = "${OASIS_SYSTEMD_SERVICE}"

# The upstream command uses Bash, ros2 pkg/launch and delay_launch.sh. The delay
# helper uses uname, awk, sleep, ip, grep and head, including iproute2's -o option.
RDEPENDS:${PN}:append = " \
    bash \
    coreutils \
    gawk \
    grep \
    iproute2-ip \
    ros2launch \
    ros2pkg \
    ros-workspace \
"

do_install:append() {
    # Install only the explicitly selected unit, never config/systemd/*.service.
    install -d "${D}${systemd_system_unitdir}/${OASIS_SYSTEMD_SERVICE}.d"
    install -m 0644 "${S}/config/systemd/${OASIS_SYSTEMD_SERVICE}" \
        "${D}${systemd_system_unitdir}/${OASIS_SYSTEMD_SERVICE}"
    install -m 0644 "${UNPACKDIR}/10-yocto.conf" \
        "${D}${systemd_system_unitdir}/${OASIS_SYSTEMD_SERVICE}.d/10-yocto.conf"
    sed -i -e 's|@ROS2_DISTRO@|${ROS_DISTRO}|g' \
        "${D}${systemd_system_unitdir}/${OASIS_SYSTEMD_SERVICE}"
    sed -i -e 's|@ROS2_DISTRO@|${ROS_DISTRO}|g' \
        -e 's|@LIBDIR@|${libdir}|g' \
        -e 's|@BASE_BINDIR@|${base_bindir}|g' \
        -e 's|@OPENCV_PYTHON_DIR@|${libdir}/${PYTHON_DIR}/site-packages|g' \
        "${D}${systemd_system_unitdir}/${OASIS_SYSTEMD_SERVICE}.d/10-yocto.conf"
}

# systemd.bbclass packages the selected unit. Include its vendor drop-in in the
# rootfs as well so it is included in OTA updates.
FILES:${PN}:append = " \
    ${systemd_system_unitdir}/${OASIS_SYSTEMD_SERVICE}.d/10-yocto.conf \
"
