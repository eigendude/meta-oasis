SUMMARY = "/etc/skel for the OASIS Distribution"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2f6ec892a474b38b927af638da43b05c"

SRCREV = "56805c82ef9666b49e9c629f5031053d280bebe2"
SRC_URI = "git://github.com/eigendude/OASIS-skel.git;protocol=https"

S = "${WORKDIR}/git"

inherit allarch

do_install() {
	install -d ${D}${sysconfdir}
	cp -a ${S}/etc/skel ${D}${sysconfdir}
}

PACKAGES =+ "oasis-skel-htop \
             oasis-skel-gnome2 \
            "

FILES_oasis-skel-htop = "${sysconfdir}/skel/.config/htop" 
FILES_oasis-skel-gnome2 = "${sysconfdir}/skel/.config/gconf" 

