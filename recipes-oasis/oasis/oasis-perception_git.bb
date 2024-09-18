require oasis-ament-cmake.inc

ROS_CN = "oasis"
ROS_BPN = "oasis_perception"

DEPENDS:append = " \
    bgslibrary \
    cv-bridge \
    image-transport \
    oasis-msgs \
    rclcpp \
    sensor-msgs \
"

RDEPENDS:${PN}:append = " \
    cv-bridge \
    image-transport \
    oasis-msgs \
    rclcpp \
    sensor-msgs \
"
