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

# SmartHome-specific packages
IMAGE_INSTALL:append = " \
    packagegroup-oasis \
"
