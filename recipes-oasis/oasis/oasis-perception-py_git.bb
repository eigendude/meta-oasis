require oasis-ament-python.inc
require oasis-systemd.inc

ROS_CN = "oasis"
ROS_BPN = "oasis_perception_py"

OASIS_SYSTEMD_SERVICE = "oasis_perception.service"

RDEPENDS:${PN}:append = " \
    oasis-drivers-py \
    oasis-home \
    python3-numpy \
    rclcpp-components \
    rclpy \
"
