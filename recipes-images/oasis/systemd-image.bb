# OASIS image to test systemd

require console-base-image.bb


CONMANPKGS ?= "connman connman-client connman-oasis-settings connman-plugin-loopback connman-plugin-ethernet connman-plugin-wifi"
CONMANPKGS_libc-uclibc = ""

IMAGE_INSTALL += " \
	${CONMANPKGS} \
"

export IMAGE_BASENAME = "systemd-image"

