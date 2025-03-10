################################################################################
#
# Base graphical image with the Chromium web browser and OASIS
#
################################################################################

require ../../layers/meta-curie/recipes-images/curie/browser.bb

################################################################################
# Metadata
################################################################################

# Image description
DESCRIPTION = "Base graphical image with the Chromium web browser and OASIS."

# Set image basename
export IMAGE_BASENAME = "browser-oasis"

################################################################################
# Packages
################################################################################

IMAGE_INSTALL += " \
    chromium-ozone-wayland \
"
