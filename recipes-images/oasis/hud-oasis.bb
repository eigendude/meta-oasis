################################################################################
#
# Base graphical image with the Gnome desktop and OASIS
#
################################################################################

require ../../layers/meta-curie/recipes-images/curie/hud.bb

################################################################################
# Metadata
################################################################################

# Image description
DESCRIPTION = "Base graphical image with the Gnome desktop and OASIS."

# Set image basename
export IMAGE_BASENAME = "hud-oasis"

################################################################################
# Packages
################################################################################

IMAGE_INSTALL += " \
    gdm \
    gnome-control-center \
    gnome-disk-utility \
    gnome-shell \
    gnome-shell-extensions \
    gnome-software \
    gnome-system-monitor \
    gnome-terminal \
    gnome-tweaks \
    kmscube \
    mesa-demos \
    nautilus \
    vulkan-tools \
    weston \
"
