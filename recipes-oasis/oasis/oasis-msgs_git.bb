require oasis-ament-cmake.inc

ROS_CN = "oasis"
ROS_BPN = "oasis_msgs"

DEPENDS:append = " \
    apriltag-msgs \
    geometry-msgs \
    nav-msgs \
    rosidl-default-generators-native \
    sensor-msgs \
    std-msgs \
"

RDEPENDS:${PN}:append = " \
    apriltag-msgs \
    geometry-msgs \
    nav-msgs \
    rosidl-default-runtime \
    sensor-msgs \
    std-msgs \
"

# ROS interface packages install runtime-needed unversioned *.so files. The
# default packaging logic assigns unversioned shared libs to -dev
# (FILES_SOLIBSDEV), which then causes ${PN} to rdepend on ${PN}-dev and trips
# the dev-deps QA check. Disable that behavior for this recipe.
FILES_SOLIBSDEV = ""
