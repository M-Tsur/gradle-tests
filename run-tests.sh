#!/bin/bash
set -e

CONTAINER_NAME="gradle-daemon"

# Check if the container is running
if ! docker ps --format '{{.Names}}' | grep -q "^${CONTAINER_NAME}$"; then
    echo "Starting Gradle daemon container..."
    docker compose up -d --build
    echo "Waiting for daemon to warm up..."
    sleep 5
fi

echo "Running tests via remote Gradle daemon..."
docker exec "${CONTAINER_NAME}" gradle test "$@"

echo ""
echo "Test reports available at: build/reports/tests/test/index.html"
