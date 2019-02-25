#!/bin/bash

${ANDROID_SDK}/tools/emulator @Nexus_5X_API_26 &

#product test need run server
#cd ../server && ./run.sh &
cd ..
#./gradlew clean pmd findbugs checkstyle lintProdDebug testProdDebugUnitTest connectedProdDebugAndroidTest

#mock test
./gradlew clean pmd findbugs checkstyle lintMockDebug testMockDebugUnitTest connectedMockDebugAndroidTest

./gradlew sonarqube -Dsonar.branch=master -Dsonar.host.url=http://localhost:9001

# kill emulator
kill $(lsof -t -i:5554)
adb kill-server

# kill python server
kill $(lsof -t -i:5001)