const fs = require("fs");
const path = require("path");

function getFolderStructure(dir, indent = "") {
    try {
        const files = fs.readdirSync(dir);
        for (const file of files) {
            const fullPath = path.join(dir, file);
            const stats = fs.statSync(fullPath);
            if (stats.isDirectory()) {
                console.log(indent + "📁 " + file);
                getFolderStructure(fullPath, indent + "  ");
            } else {
                console.log(indent + "📄 " + file);
            }
        }
    } catch (err) {
        console.error("Error reading directory:", err);
    }
}

// Change '.' to the path of the folder you want to analyze
const rootDir = "."; 
console.log("Project Folder Structure:");
getFolderStructure(rootDir);
