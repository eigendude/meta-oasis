# Avoid the clang-backed openmp recipe; use GCC libgomp instead
PACKAGECONFIG:remove = "openmp"
PACKAGECONFIG:append = " gomp"

# Disable building tests
PACKAGECONFIG:remove = "tests"
