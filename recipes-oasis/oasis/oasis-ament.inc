require oasis.inc

inherit ros_component
inherit ros_distro_${ROS_DISTRO}

S = "${WORKDIR}/git/${ROS_BPN}"
