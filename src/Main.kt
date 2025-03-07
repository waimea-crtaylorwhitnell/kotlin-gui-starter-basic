/**
 * ===============================================================
 * Kotlin GUI Basic Starter
 * ===============================================================
 *
 * This is a starter project for a simple Kotlin GUI application.
 * The Java Swing library is used, plus the FlatLAF look-and-feel
 * for a reasonably modern look.
 */

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    MainWindow()            // Create and show the UI
}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passed as an argument
 */
class MainWindow : JFrame(), ActionListener, KeyListener {

    // Fields to hold the UI elements
    private lateinit var greetingLabel: JLabel
    private lateinit var textBox: JTextField
    private lateinit var helloButton: JButton
    private lateinit var goodbyeButton: JButton

    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin Swing GUI Demo"
        contentPane.preferredSize = Dimension(600, 350)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val defaultFont = Font(Font.SANS_SERIF, Font.PLAIN, 36)

        greetingLabel = JLabel("Click a button...")
        greetingLabel.horizontalAlignment = SwingConstants.CENTER
        greetingLabel.bounds = Rectangle(50, 20, 500, 100)
        greetingLabel.font = defaultFont
        add(greetingLabel)

        textBox = JTextField()
        textBox.horizontalAlignment = SwingConstants.CENTER
        textBox.bounds = Rectangle(33, 100, 533, 80)
        textBox.addActionListener(this)
        textBox.addKeyListener(this)
        add(textBox)

        helloButton = JButton("Hello!")
        helloButton.bounds = Rectangle(33,200,200,100)
        helloButton.foreground = Color.BLUE
        helloButton.background = Color(0, 33, 66)
        helloButton.font = defaultFont
        helloButton.addActionListener(this)     // Handle any clicks
        add(helloButton)

        goodbyeButton = JButton("Goodbye!")
        goodbyeButton.bounds = Rectangle(366,200,200,100)
        goodbyeButton.foreground = Color.BLUE
        goodbyeButton.background = Color(0, 33, 66)
        goodbyeButton.font = defaultFont
        goodbyeButton.addActionListener(this)     // Handle any clicks
        add(goodbyeButton)
    }


    /**
     * Handle any UI events (e.g. button clicks)
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            textBox -> {
                println("Name has been changed!")
            }
            helloButton -> {
                println("Hello button pressed!")
                if (textBox.text.isNotEmpty()) {
                    greetingLabel.text = "Hello there ${textBox.text}!"
                }
                else {
                    greetingLabel.text = "Hello there intruder!"
                }
            }
            goodbyeButton -> {
                println("Goodbye button pressed!")
                if (textBox.text.isNotEmpty()) {
                    greetingLabel.text = "Oh... ${textBox.text}"
                }
                else {
                    greetingLabel.text = "Oh... intruder"
                }
            }
        }
    }

    override fun keyTyped(e: KeyEvent?) {
        println("Key TYPED: ${e?.keyChar}")
    }

    override fun keyPressed(e: KeyEvent?) {
        println("Key PRESSED: ${e?.keyCode}")
    }

    override fun keyReleased(e: KeyEvent?) {
        println("Key RELEASED: ${e?.keyCode}")

        if (e?.keyCode in KeyEvent.VK_A..KeyEvent.VK_Z) {
            println("Letter key!")
        }
        else {
            e?.consume()
        }
    }

}

