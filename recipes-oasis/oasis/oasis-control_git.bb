require oasis-ament-python.inc

SRC_URI:append = " \
    file://0001-control-Fix-install-paths-for-data-files.patch \
"

ROS_CN = "oasis"
ROS_BPN = "oasis_control"

RDEPENDS:${PN}:append = " \
    geometry-msgs \
    oasis-msgs \
    sensor-msgs \
"
