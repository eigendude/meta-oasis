require oasis-ament-cmake.inc

ROS_CN = "oasis"
ROS_BPN = "oasis_drivers_cpp"

DEPENDS:append = " \
    geometry-msgs \
    i2cdevlib \
    libcec \
    libeigen \
    nav-msgs \
    oasis-msgs \
    rclcpp \
    rclcpp-components \
    rcutils \
    sensor-msgs \
    std-msgs \
    tf2-ros \
    udev \
    yaml-cpp \
"

RDEPENDS:${PN}:append = " \
    oasis-msgs \
    rclcpp \
"
