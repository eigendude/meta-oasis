require oasis-ament-cmake.inc

ROS_CN = "oasis"
ROS_BPN = "oasis_drivers_cpp"

DEPENDS:append = " \
    i2cdevlib \
    libcec \
    libeigen \
    oasis-msgs \
    rclcpp \
    rcutils \
    std-msgs \
    udev \
    yaml-cpp \
"

RDEPENDS:${PN}:append = " \
    oasis-msgs \
    rclcpp \
"
