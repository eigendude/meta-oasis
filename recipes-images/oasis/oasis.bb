################################################################################
#
# Basic image with smarthome functionality with OASIS
#
################################################################################

require ../../layers/meta-curie/recipes-images/curie/core.bb

################################################################################
# Metadata
################################################################################

# Image description
DESCRIPTION = "Basic image with smarthome functionality."

# License metadata
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

# Set image basename
export IMAGE_BASENAME = "oasis"

################################################################################
# Packages
################################################################################

# SmartHome-specific packages
IMAGE_INSTALL:append = " \
    packagegroup-oasis \
"
