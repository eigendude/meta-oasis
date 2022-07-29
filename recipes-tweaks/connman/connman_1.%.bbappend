FILESEXTRAPATHS_prepend := "${THISDIR}/oasis:"

SRC_URI += "file://settings"

do_install_append() {
	install -d ${D}${localstatedir}/lib/connman/
	install -m 0644 ${WORKDIR}/settings ${D}${localstatedir}/lib/connman/
}

PACKAGES =+ "${PN}-oasis-settings"

FILES_${PN}-oasis-settings = "${localstatedir}/lib/connman/settings"
RDEPENDS_${PN}-oasis-settings = "${PN}"
LICENSE_FLAGS_${PN}-oasis-settings = "non-commercial"
