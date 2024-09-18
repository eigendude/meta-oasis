SUMMARY = "A C++ Background Subtraction Library"
DESCRIPTION = "bgslibrary is a C++ Background Subtraction Library with wrappers for Python, MATLAB, Java and GUI on QT."
HOMEPAGE = "https://github.com/andrewssobral/bgslibrary"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d2259a5cee4bdd5c7936795c3dd811d7"

SRC_URI = " \
    git://github.com/andrewssobral/bgslibrary.git;protocol=https;branch=master \
    file://0001-Remove-cv-imshow-calls-inside-of-algorithms.patch \
"
SRCREV = "2a6cd015e100212703cd144ace86f0d3decc41e4"

DEPENDS = " \
    opencv \
"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = " \
    -DBGS_CORE_STATIC=ON \
"

FILES:${PN}:append = " \
    ${libdir}/lib*.so.* \
"
FILES:${PN}-dev:append = " \
    ${includedir} \
    ${libdir}/lib*.so \
"

# Remove the /usr/bin/bgslibrary executable, as it's not needed in the final
# image
do_install:append() {
    rm -rf ${D}${bindir}
}
