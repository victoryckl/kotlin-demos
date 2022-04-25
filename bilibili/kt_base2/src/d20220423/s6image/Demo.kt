package d20220423.s6image

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun main(args: Array<String>) {
    var image = BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB)
    image.apply {
        for (i in 0..99) {
            for (j in 0..99) {
                setRGB(i, j, 0xff0000)
            }
        }
    }
    ImageIO.write(image, "bmp", File("a.bmp"))
}