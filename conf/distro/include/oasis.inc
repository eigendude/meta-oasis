SOC_FAMILY ?= ""

# Yocto work around for missing ONLINE_PACKAGE_MANAGEMENT support
ONLINE_PACKAGE_MANAGEMENT = "full"

#Set the right arch for the feeds
#Alphabetically sorted

FEED_ARCH ?= "${TUNE_PKGARCH}"
TUNE_ARMPKGARCH = "${ARMPKGARCH}${ARMPKGSFX_DSP}${ARMPKGSFX_EABI}${ARMPKGSFX_ENDIAN}${ARMPKGSFX_FPU}"
FEED_ARCHS ?= "${TUNE_PKGARCH} ${TUNE_ARMPKGARCH}"

#blackfin machines
FEED_ARCH_bfin          = "blackfin"

# Put links to sources in deploy/sources to make it easier for people to be GPL compliant
#INHERIT += "src_distribute_local"
SRC_DIST_LOCAL ?= "symlink"

# Can be "glibc", "musl" or "uclibc"
TCLIBC ?= "glibc"

# The things *libc can provide.
PREFERRED_PROVIDER_eglibc = "glibc"

PREFERRED_PROVIDER_virtual/gettext ??= "gettext"
PREFERRED_PROVIDER_linux-libc-headers-nativesdk = "linux-libc-headers-nativesdk"

require conf/distro/include/oasis-${TCLIBC}.inc

# Set some java bits
require conf/distro/include/oasis-java.inc

# "arm" "thumb"
#    The instruction set the compiler should use when generating application
#    code.  The kernel is always compiled with arm code at present.  arm code
#    is the original 32 bit ARM instruction set, thumb code is the 16 bit
#    encoded RISC sub-set.  Thumb code is smaller (maybe 70% of the ARM size)
#    but requires more instructions (140% for 70% smaller code) so may be
#    slower.
#    thumb 2 is an evolution of the original thumb instruction set which strives
#    to keep the code size advantages without the performance penality.
#    When setting thumb the compiler will use thumb or thumb2 depending on what
#    the selected arm architecture.

ARM_INSTRUCTION_SET ??= "thumb"
ARM_INSTRUCTION_SET_armv4 ?= "arm"
ARM_INSTRUCTION_SET_armv5 ?= "arm"
ARM_INSTRUCTION_SET_armv6 ?= "arm"

#Use this variable in feeds and other parts that need a URI
OASIS_URI ?= "http://feeds.oasis-distribution.org"

#Use this variable to select which recipe you want to use to get feed configs (/etc/ipkg/, /etc/apt/sources.list)
# usefull for derivative distros and local testing
# As this is runtime we can't and won't use virtual/feed-configs
OASIS_FEED_CONFIGS ??= "oasis-feed-configs"

#Set the default maintainer to oasis-dev
MAINTAINER = "Garrett Brown <eigendebugger@gmail.com>"

#use debian style naming
INHERIT += "debian"

#activate config checker
INHERIT += "sanity" 

#activate the blacklister
INHERIT += "blacklist"

#make devshell available as task
INHERIT += "devshell" 

#run QA tests on builds and packages and log them  
INHERIT += "insane"
QA_LOG = "1"

# Log information on images and packages
# https://github.com/eigendude/oasis-buildhistory/
INHERIT += "buildhistory"
BUILDHISTORY_COMMIT = "1"

#run QA tests on recipes
#INHERIT += "recipe_sanity"

#have a shared state a.k.a package-staging2
INHERIT += "sstate"

OASIS_PKG_FORMAT ?= "ipk"
require conf/distro/include/oasis-package-${OASIS_PKG_FORMAT}.inc

# MACHINE_KERNEL_PR if not defined can cause parsing failures
# since MACHINE_KERNEL_PR is used in PR assignments in some recipes
# (meta-ti comes to mind) which means when creating FILESPATH
# it will try to evaluate it and if its undefined then python
# will except
#
# so for machines which do not define it lets define it to be empty

MACHINE_KERNEL_PR ??= "r0"

# We don't want to keep OABI compat
ARM_KEEP_OABI = "0"
# Do keep OABI compat for om-gta01 to keep the gllin binary working
ARM_KEEP_OABI_pn-linux-openmoko-2.6.24_om-gta01 = "1"
ARM_KEEP_OABI_pn-linux-openmoko-2.6.28_om-gta01 = "1"


#Generate locales on the buildsystem instead of on the target. Speeds up first boot, set to "1" to enable
PREFERRED_PROVIDER_qemu-native = "qemu-native"
ENABLE_BINARY_LOCALE_GENERATION ?= "1"

# We only want to build UTF8 locales
LOCALE_UTF8_ONLY = "1"

#qemu doesn't like this fp
ENABLE_BINARY_LOCALE_GENERATION_ep9312 = "0"

#qemu has taken a dislike to armeb as well
ENABLE_BINARY_LOCALE_GENERATION_armeb = "0"

# Prelink images
INHERIT += "image-prelink"

#Name the generated images in a sane way
IMAGE_NAME = "${DISTRO_NAME}-${IMAGE_BASENAME}-${TCLIBC}-${OASIS_PKG_FORMAT}-${DISTRO_VERSION}-${MACHINE}"
DEPLOY_DIR_IMAGE = "${DEPLOY_DIR}/images/${MACHINE}"

# Prefer ext4 images where possible
SDIMG_ROOTFS_TYPE = "ext4"

# OASIS *always* has some form of release config, so error out if someone thinks he knows better 
DISTRO_CHECK := "${@d.getVar("DISTRO_VERSION",1) or bb.fatal('Remove this line or set a dummy DISTRO_VERSION if you really want to build an unversioned distro')}"

# We want images supporting the following features (for packagegroup(-core)-base)
DISTRO_FEATURES = "alsa argp bluetooth ext2 ipv4 ipv6 irda largefile nfs pam pci pcmcia ppp smbfs systemd usbgadget usbhost vfat wifi xattr zeroconf"

# Disable sysvinit for recipes with systemd or non-sysvinit support
DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"

# EFL tweaks
include conf/distro/include/efl-from-svn.inc

# Yocto tweaks
require conf/distro/include/oasis-core-tweaks.inc
