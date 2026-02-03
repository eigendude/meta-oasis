SUMMARY = "I2C device library collection for AVR/Arduino or other C++-based MCUs"
DESCRIPTION = "The I2C Device Library is a collection of uniform and well-documented classes to provide simple and intuitive interfaces to an ever-growing collection of I2C devices."
HOMEPAGE = "https://www.i2cdevlib.com/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

# Revision used to retrieve build files
I2CDEVLIB_REV = "3322c31b8ccbae4e53a25051b93a4c211afc3d26"

SRC_URI = " \
    git://github.com/jrowberg/i2cdevlib.git;protocol=https;branch=master \
    https://raw.githubusercontent.com/eigendude/OASIS/${I2CDEVLIB_REV}/oasis_tooling/config/i2cdevlib/CMakeLists.txt;name=cmake;downloadfilename=CMakeLists.txt-${I2CDEVLIB_REV} \
    https://raw.githubusercontent.com/eigendude/OASIS/${I2CDEVLIB_REV}/oasis_tooling/config/i2cdevlib/package.xml;name=pkgxml;downloadfilename=package.xml-${I2CDEVLIB_REV} \
"

SRCREV = "a98805775f5c14b618387742d5ac6ac9c14e215e"
SRC_URI[cmake.sha256sum]  = "28b91bd6be8b712419a006d9982cb06e5589cccb1026202933be97f1ab1a7398"
SRC_URI[pkgxml.sha256sum] = "fd060d66a96d6a261035b4808bed8ea0240994b2ae1f0f31b0fea1068ad7acc3"

S:scarthgap = "${WORKDIR}/git"

inherit ros_ament_cmake
inherit ros_component
inherit ros_distro_${ROS_DISTRO}

DEPENDS = " \
    ament-cmake-ros-native \
"

do_configure:prepend() {
    cp "${UNPACKDIR}/CMakeLists.txt-${I2CDEVLIB_REV}" "${S}/CMakeLists.txt"
    cp "${UNPACKDIR}/package.xml-${I2CDEVLIB_REV}" "${S}/package.xml"
}
