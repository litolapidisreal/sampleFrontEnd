#Sample Notes
**Download Latest version of Angular**

    ng update @angular/cli
Build Latest Version of Project

    ng build
Run Latest Version of Project

    ng serve
Create component

    ng generate component {componentName}
Create Routing

    ng g module app-routing 
Create Custom Pipe

    ng generate pipe nameOfPipe
# Building a Program
#### 1. npm run install
#### 2. Change value package.json
##### LINE 2: name: "{name-of-folder}"; 
##### LINE 19: "unpkg": "dist/my-stencil-app/{name-of-folder}.esm.js"
#### 3. Change value stencil-config.ts
##### LINE 5: namespace: '{name-of-folder}'; 
###### NOTE: name-of-folder SHOULD BE HYPHENATED
#### 4. npm run build
