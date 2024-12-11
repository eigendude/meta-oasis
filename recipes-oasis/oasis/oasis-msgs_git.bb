require oasis-ament-cmake.inc

ROS_CN = "oasis"
ROS_BPN = "oasis_msgs"

DEPENDS:append = " \
    rosidl-default-generators-native \
    sensor-msgs \
    std-msgs \
"

RDEPENDS:${PN}:append = " \
    rosidl-default-runtime \
    sensor-msgs \
    std-msgs \
"

# TODO: Fixes bitbake error
INSANE_SKIP:${PN} += "dev-deps"
