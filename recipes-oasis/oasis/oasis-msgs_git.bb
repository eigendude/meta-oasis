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

# Disable QA checks for -dev package because oasis-msgs-dev is required at runtime
INSANE_SKIP:${PN} += "dev-deps"

# Disable the dev-elf QA check for the -dev package since our ROS build installs
# shared libraries as actual files (not symlinks) which are needed at runtime.
INSANE_SKIP:${PN}-dev = "dev-elf"
