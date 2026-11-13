DESCRIPTION = "OASIS smarthome operating system package group"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS:${PN} = " \
    oasis-control \
    oasis-drivers-cpp \
    oasis-drivers-py \
    oasis-home \
    oasis-msgs \
    oasis-perception-cpp \
    oasis-perception-py \
"

# oasis-perception-cpp requires APIs available in Lyrical but missing in Kilted.
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_DISTRO', 'kilted', 'oasis-perception-cpp', '', d)}"

# Also include the full suite of core ros tools
RDEPENDS:${PN}:append = " \
    ros-core \
"
