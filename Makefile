# Define a phony target to ensure 'make' always runs the 'default' actions
.PHONY: all

# The default target that runs when you just type 'make'
all: set_version_and_dist

# Rule to set the JADX_VERSION environment variable and run gradlew dist
set_version_and_dist:
	@echo "Setting JADX_VERSION to current date + 'dev'..."
	# Use 'date +%Y%m%d%H%M%S' to get a detailed current timestamp
	JADX_VERSION=$$(date +%Y%m%d) \
	./gradlew dist
	@echo "---"
	@echo "Build process complete."

# Optional: A clean target for good practice
clean:
	./gradlew clean
