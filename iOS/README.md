## How to add C library to Xcode project

**Run `build.sh` in the `swift-adapter-rust` project first**

### Add library files
  1. Click the project in the Project navigator panel
  2. Under 'General' > 'Frameworks, Libraries and Embedded Content'
  3. Click '+', 'Add Other' and choose 'Add Files'
  4. Select `.a` file from `<adapter>/target/universal/release`
  5. Click 'Open'
  6. Click '+', 'Add Other' and choose 'Add Files'
  7. Select `.a` file from `<adapter>/target/aarch64-apple-ios-sim/release`
  8. Click 'Open'
  9. Click '+', search for 'libres'
  10. Select `libresolv.tbd`
  11. Click 'Add'

### Add library search paths (these have to be full paths)
12. Under 'Build Settings' > 'Search Paths'
13. Expand 'Library Search Paths'
14. Click the '+' for 'Debug' and 'Release' twice, then for both
	* For the first row
		* Click 'Any Architecture | Any SDK' and select 'Any iOS Simulator SDK'
		* Enter `<adapter-project>/target/aarch64-apple-ios-sim/release`
		* e.g. `$(PROJECT_DIR)/../swift-adapter-rust/target/aarch64-apple-ios-sim/release`
	* For the second row
  		* Click 'Any Architecture | Any SDK' and select 'Any iOS SDK'
  		* Enter `<adapter-project>/target/universal/release`
	  	* e.g. `$(PROJECT_DIR)/../swift-adapter-rust/target/universal/release`
  
### Import header
  1. From the menu click 'File' > 'Add Files to <project>'
  2. Select `.h` file from `swift-adapter-rust/src`
  3. Click 'Add'

### Create bridging header
  1. From the menu click 'File' > 'New' > 'File'
  2. Choose 'Header File'
  3. Click 'Next'
  4. Enter a name, such as 'Lib-Bridging-Header.h'
  5. Add `#import "<file>.h"` inside `#ifndef` where `<file>` is the name of the file imported from **Import header**
  6. Click the project in the Project navigator panel
  7. Under 'Build Settings' > 'Swift Compiler - General'
  8. Change `Objective-C Bridging Header` contents to `$(PROJECT_DIR)/<project name>/<bridging-file>`, e.g. `$(PROJECT_DIR)/iOS/Lib-Bridging-Header.h`

### Add files to project
1. Click the project in the Project navigator panel
2. Expand 'Frameworks'
3. For each `.a` file and `libresolv`
	* Under 'Target Membership' select the project name
	* e.g `iOS`

The methods inside the header can now be called from any swift file

#### Useful links

* https://mozilla.github.io/firefox-browser-architecture/experiments/2017-09-06-rust-on-ios.html