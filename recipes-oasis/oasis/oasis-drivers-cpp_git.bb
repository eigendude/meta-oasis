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

# Disable QA checks for -dev package because oasis-msgs-dev is required at runtime
INSANE_SKIP:${PN} += "dev-deps"
