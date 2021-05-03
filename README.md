<img align="right" src="https://user-images.githubusercontent.com/13753840/116860045-3dff0500-ac01-11eb-86c4-aea9161fdcd8.png" height="200" width="200">

# NPC API - NPCSystem
[![Release Status](https://github.com/NgLoader/NPCSystem/workflows/Releases/badge.svg)](https://github.com/NgLoader/NPCSystem/releases/latest) [![Build Status](https://github.com/NgLoader/NPCSystem/workflows/Build/badge.svg)](https://github.com/NgLoader/NPCSSystem/actions?query=workflow%3ABuild) [![](https://jitpack.io/v/NgLoader/NPCSystem.svg)](https://jitpack.io/#NgLoader/NPCSystem)

### Features
* Plug & Play
* Support for Spigot based servers 1.16.5+ 

## Requirements
- Java 8 or higher
- Spigot and (proably) any other fork of Spigot (1.16.5 or higher)
- [ProtocolLib](https://www.spigotmc.org/resources/protocollib.1997) 4.0 or higher

## Developer

### Clone
1. Clone this repo "git clone https://github.com/Imprex-Development/Orebfuscator.git"
2. Open eclipse and right click on the "Project Explorer"
3. Click "Import..."
4. Maven -> Existing Maven Projects
5. Select the downloaded repo

### Build
1. Click right click on the Orebfuscator-repo folder and select "Run as" -> "Maven Build..."
2. Put into Goals this "clean compile package"
3. Click Run
4. Your jar will be builded under the folder "target"

### Maven
```maven
      <repositories>
            <repository>
                 <id>jitpack.io</id>
                 <url>https://jitpack.io</url>
            </repository>
       </repositories>


       <dependency>
            <groupId>com.github.NgLoader</groupId>
            <artifactId>NPCSystem</artifactId>
            <version>VERSION</version>
       </dependency>
```

### Release a new version
1. git tag **version** -m "**description**"
2. git push origin **version**

