DESCRIPTION = "OASIS, a smart home operating system based on ROS 2"
HOMEPAGE = "https://github.com/eigendude/OASIS"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=82f0323c08605e5b6f343b05213cf7cc"

SRC_URI = "git://git@github.com/eigendude/OASIS.git;protocol=https;branch=main"
SRCREV = "${AUTOREV}"

RDEPENDS:${PN}:append = " \
    rmw-fastrtps-dynamic-cpp \
"
