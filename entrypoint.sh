#!/bin/bash
set -e

echo "=== Gradle Daemon Container ==="
echo "Warming up the Gradle daemon..."

cd /project

if [ -f "build.gradle" ]; then
    gradle --daemon --status 2>/dev/null || true
    gradle --daemon help --quiet 2>/dev/null || true
    echo "Gradle daemon is ready."
else
    echo "No build.gradle found yet — daemon will start on first build."
fi

echo "Container is running. Use 'docker exec' to run Gradle commands."
echo "Example: docker exec gradle-daemon gradle test"

# Keep the container alive so the daemon persists between builds
tail -f /dev/null
