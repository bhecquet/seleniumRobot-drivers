# seleniumRobot-drivers
drivers for seleniumRobot

From seleniumRobot version >= 4.x, drivers will not be provided with code, following what selenium did some years ago. This will reduce the size of core and grid artifacts which get released at higher frequency than drivers.
The drawback is that it's now necessary to deploy drivers AND code

List of drivers to download is specified in pom.xml
If you want to provide custom drivers (not the ones downloaded from internet), 
- place them, in `selenium-<os>-driver/custom` folder
- execute the maven command with `-Dskip.custom.driver=false`
they will automatically be taken into account
