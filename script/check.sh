#!/bin/bash

${ANDROID_SDK}/tools/emulator @Nexus_5X_API_26 &

cd ../server && ./run.sh &
cd ..

./gradlew --stop
#./gradlew clean pmd findbugs checkstyle lintProdDebug testProdDebugUnitTest connectedProdDebugAndroidTest
./gradlew clean pmd findbugs checkstyle lintMockDebug testMockDebugUnitTest connectedMockDebugAndroidTest
./gradlew sonarqube -Dsonar.branch=chatsfragment -Dsonar.host.url=http://localhost:9001

# kill emulator
kill $(lsof -t -i:5554)
adb kill-server

# kill python server
kill $(lsof -t -i:5001)