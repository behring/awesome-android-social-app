#!/bin/bash
# kill emulator
kill $(lsof -t -i:5554)

# kill python server
kill $(lsof -t -i:5001)

$ANDROID_SDK/tools/emulator @Nexus_5X_API_26 &

cd ../server && ./run.sh &
cd ..
#./gradlew sonarqube -Dsonar.host.url=http://localhost:9000
./gradlew --stop
./gradlew clean pmd findbugs checkstyle lint testDebugUnitTest connectedAndroidTest assemble

