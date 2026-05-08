# Avoid the clang-backed openmp recipe and GCC-backed libgomp recipe
PACKAGECONFIG:remove = "openmp"
PACKAGECONFIG:remove = "gomp"

# Disable building tests
PACKAGECONFIG:remove = "tests"
