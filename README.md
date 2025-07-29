# 🔢 Fibonacci Network Project

A Java-based **Client-Server** application with a **Graphical User Interface (GUI)** that computes Fibonacci numbers over a TCP/IP network.

---

## 🚀 Project Features

- 🌐 **Client-Server Communication** using sockets  
- 🖥️ **Swing-based GUI** for easy input/output  
- ⚙️ Server performs the Fibonacci calculation  
- 🖼️ Includes screenshots for visual reference

---

## 📂 Project Structure

fibonacci/network/
├── FibonacciClient.java # Handles client-side networking
├── FibonacciClientGUI.java # Graphical UI for user interaction
├── FibonacciServer.java # Server that calculates Fibonacci numbers
├── SS1Code and FCGUI.PNG # Screenshot: Server & GUI Code
├── SS2GUI.PNG # Screenshot: GUI running

---

---

## 📄 .gitignore

To avoid committing compiled `.class` files or IDE-specific files, create a `.gitignore` with:

```
*.class
*.log
*.iml
.idea/
.vscode/
```


---

## 📦 Requirements

- Java Development Kit (JDK) 8 or higher
- No external libraries required



##  How to Run

### 1️⃣ Start the Server
```bash
javac FibonacciServer.java
java FibonacciServer

2️⃣ Run the Client with GUI

javac FibonacciClient.java FibonacciClientGUI.java
java FibonacciClientGUI
```

🛠️ Built With

Java SE
Swing (GUI)
Sockets (Networking)

