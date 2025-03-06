require oasis-ament-python.inc

ROS_CN = "oasis"
ROS_BPN = "oasis_control"

RDEPENDS:${PN}:append = " \
    geometry-msgs \
    oasis-msgs \
    sensor-msgs \
"
