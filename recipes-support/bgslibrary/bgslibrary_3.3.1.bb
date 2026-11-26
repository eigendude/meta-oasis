SUMMARY = "A C++ Background Subtraction Library"
DESCRIPTION = "bgslibrary is a C++ Background Subtraction Library with wrappers for Python, MATLAB, Java and GUI on QT."
HOMEPAGE = "https://github.com/andrewssobral/bgslibrary"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d2259a5cee4bdd5c7936795c3dd811d7"

SRC_URI = " \
    git://github.com/andrewssobral/bgslibrary.git;protocol=https;branch=master \
    file://0001-Disable-imshow-calls.patch \
"

SRCREV = "e34cbde4ab2ac30bf726bba29fa3d1b7aef4739a"

DEPENDS = " \
    opencv \
"

S:scarthgap = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = " \
    -DBGS_CORE_STATIC=ON \
    -DCMAKE_POLICY_VERSION_MINIMUM=3.5 \
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
