require oasis-ament-cmake.inc

ROS_CN = "oasis"
ROS_BPN = "oasis_drivers_cpp"

DEPENDS:append = " \
    libcec \
    oasis-msgs \
    rclcpp \
    rcutils \
    std-msgs \
    udev \
"

RDEPENDS:${PN}:append = " \
    oasis-msgs \
    rclcpp \
"
