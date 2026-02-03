require oasis-ament-python.inc

ROS_CN = "oasis"
ROS_BPN = "oasis_control"

RDEPENDS:${PN}:append = " \
    geometry-msgs \
    message-filters \
    nav-msgs \
    oasis-msgs \
    sensor-msgs \
    std-msgs \
    tf2-msgs \
    tf2-ros \
"
