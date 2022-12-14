DESCRIPTION = "Task packages for the OASIS distribution"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r32"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = "\
    gpe-edit \
    gpe-gallery \
    gpe-calculator \
    gpe-clock \
    gpe-plucker \
    gpe-terminal \
    gpe-watch \
    gpe-what \
    matchbox-panel-hacks \
    ${@bb.utils.contains("COMBINED_FEATURES", "wifi", "gpe-aerial", "",d)} \
    gpe-soundbite \
    ${@bb.utils.contains("MACHINE_FEATURES", "touchscreen", "rosetta", "",d)} \
    gpe-scap \
    gpe-windowlist"

