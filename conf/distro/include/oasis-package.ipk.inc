INHERIT += "package_ipk"

OASIS_FEED_CONFIGS ?= "oasis-feed-configs"

EXTRAOPKGCONFIG = "opkg-config-base ${OASIS_FEED_CONFIGS}"

OASIS_IPK_UPDATE_ALTERNATIVES ?= "update-alternatives-opkg"

DISTRO_UPDATE_ALTERNATIVES = "${OASIS_IPK_UPDATE_ALTERNATIVES}"

# we need the same provider for opkg and u-a
PREFERRED_PROVIDER_virtual/update-alternatives-native ?= "opkg-utils-native"
PREFERRED_PROVIDER_virtual/update-alternatives = "opkg-utils"
VIRTUAL-RUNTIME_update-alternatives = "${OASIS_IPK_UPDATE_ALTERNATIVES}"
