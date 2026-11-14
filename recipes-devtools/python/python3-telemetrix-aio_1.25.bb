SUMMARY = "Asynchronous Telemetrix client"
HOMEPAGE = "https://github.com/MrYsLab/telemetrix-aio"
LICENSE = "AGPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://pyproject.toml;beginline=17;endline=17;md5=a07059d9981c2637f21c459978281f02"

PYPI_PACKAGE = "telemetrix_aio"
SRC_URI[sha256sum] = "6433bcf61f2a8d5f71e3249f747a6fdf4d2bc70dc50c323339efa1ec3606f73c"

inherit pypi
inherit python_setuptools_build_meta

RDEPENDS:${PN} += " \
    python3-bleak \
    python3-pyserial \
"
