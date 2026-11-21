# Student Data Form (Java Swing GUI)

Self Exercise/Exploration of Graphical User Interface in Java (Object-Oriented Programming, Assignment 3A).

- **NIM:** [your NIM]
- **Name:** [your name]

## About the Program

A simple desktop application for entering student data. The user types a student's **name**, **NIM**, and **major**, then clicks **Tambah** (or presses Enter in the major field) to add the student to the list at the bottom of the window. **Hapus Isian** clears the input fields and **Keluar** closes the program. If any field is empty, a warning dialog appears.

## Screenshot

![Screenshot of the application](screenshot.png)

## Project Structure

| File | Description |
|---|---|
| `Main.java` | Entry point. Creates `FormMahasiswa` and calls `launchFrame()`. |
| `FormMahasiswa.java` | The GUI itself: the frame, panels, components, layouts, and listener registration. |
| `Mahasiswa.java` | A plain class that stores the data of one student (name, NIM, major). |
| `TambahHandler.java` | Event listener for the **Tambah** button and the Enter key in the major field. |
| `HapusHandler.java` | Event listener for the **Hapus Isian** button. |
| `KeluarHandler.java` | Event listener for the **Keluar** button. |

## 5 GUI Components/Parts in This Code

All of the examples below are in `FormMahasiswa.java` unless stated otherwise.

### 1. Top Level Container
- `JFrame frame` is the main window ("Data Mahasiswa"). Everything else is placed inside it.
- Used in `launchFrame()` with `frame.add(...)`, `frame.pack()`, and `frame.setVisible(true)`.

### 2. Intermediate Container
Containers that hold other components and are themselves placed inside the frame:
- `JPanel panelJudul`: holds the title label.
- `JPanel panelInput`: holds the labels and text fields.
- `JPanel panelTombol`: holds the three buttons.
- `JPanel panelOutput`: holds the "Daftar Mahasiswa" label and the output area.
- `JPanel panelTengah`: holds `panelInput` and `panelTombol`.
- `JScrollPane scroll`: wraps the `JTextArea` so it can scroll.

### 3. Atomic Component
Components that cannot hold other components:
- `JLabel`: `lblJudul`, `lblNama`, `lblNim`, `lblJurusan`
- `JTextField`: `tfNama`, `tfNim`, `tfJurusan`
- `JButton`: `btnTambah`, `btnHapus`, `btnKeluar`
- `JTextArea`: `areaOutput` (read-only list of students)

### 4. Layout Classes (3 used)
| Layout | Where it is used |
|---|---|
| `BorderLayout` | The frame (`panelJudul` NORTH, `panelTengah` CENTER, `panelOutput` SOUTH), and inside `panelTengah`, `panelJudul`, and `panelOutput` |
| `GridBagLayout` | `panelInput`, so the label column stays narrow while the text field column stretches (uses `GridBagConstraints`) |
| `FlowLayout` | `panelTombol`, which places the three buttons side by side in the center |

### 5. Event Listener
Each listener is a class that **implements `ActionListener`** and overrides `actionPerformed(ActionEvent e)`:

| Listener class | Registered to | What it does |
|---|---|---|
| `TambahHandler` | `btnTambah` and `tfJurusan` | Validates the input, creates a `Mahasiswa` object, and appends it to `areaOutput` |
| `HapusHandler` | `btnHapus` | Clears the three text fields |
| `KeluarHandler` | `btnKeluar` | Calls `System.exit(0)` |

The registration happens in `launchFrame()`, for example `btnTambah.addActionListener(tambahListener);`.

## How to Run

Requires JDK (Java Development Kit) installed.

```bash
javac *.java
java Main
```

## Tech

- Java
- Swing (`javax.swing`) and AWT (`java.awt`, `java.awt.event`)
