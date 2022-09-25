import java.awt.Color;

public class KernelFilter {
    private static Picture kernel(Picture picture, double[][] weights) {
        // set the width and height of pictures;
        int width = picture.width();
        int height = picture.height();

        // set in the nrows and ncols for weight matrix;
        int nrows = weights.length;
        int ncols = weights[0].length;

        // set the center of weights matrix;
        int rCenter = (nrows / 2);
        int cCenter = (ncols / 2);
        int rColor = 0;
        int gColor = 0;
        int bColor = 0;

        int rResInt = 0;
        int gResInt = 0;
        int bResInt = 0;
        // declare the result picture;
        Picture result = new Picture(width, height);

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                // set inital value of RGB color
                double rRes = 0.0;
                double gRes = 0.0;
                double bRes = 0.0;
                // get the color at picture[w][h]
                // r, c go through weights matrix
                for (int row = 0; row < nrows; row++) {
                    for (int col = 0; col < ncols; col++) {
                        // recall width is with columns, height is with rows;
                        // get the color in picture;

                        Color color = picture.get((w + width + col - cCenter) % width, (h + height + row - rCenter) % height);
//                        if (w == 0 && h == 0) {
//                            StdOut.println("r = " + r + "," + "c = " + c);
//                            StdOut.println("(" + (w + width + c - cCenter) % width + "," + (h + height + r - rCenter) % height + ")");
//                        }
                        rColor = color.getRed();
                        gColor = color.getGreen();
                        bColor = color.getBlue();

                        // calculate RGB for the result picture;

                        rRes = rRes + weights[row][col] * rColor;
                        gRes = gRes + weights[row][col] * gColor;
                        bRes = bRes + weights[row][col] * bColor;
                    }
                }
                // Rounding;
                rResInt = (int) Math.round(rRes);
                gResInt = (int) Math.round(gRes);
                bResInt = (int) Math.round(bRes);

                // Clamping between 0 and 255
                if (rResInt > 255) rResInt = 255;
                if (gResInt > 255) gResInt = 255;
                if (bResInt > 255) bResInt = 255;
                if (rResInt < 0) rResInt = 0;
                if (gResInt < 0) gResInt = 0;
                if (bResInt < 0) bResInt = 0;

//                if (w == 0 && h == 0) {
//                    Color color00 = picture.get(0, 0);
//                    StdOut.println("picture locates at (" + w + ", " + h + ")");
//                    StdOut.println("picture color is: red = " + color00.getRed() + ", green = " + color00.getGreen() + ", blue = " + color00.getBlue());
//                    StdOut.println("result color is: red = " + rResInt + ", green = " + gResInt + ", blue = " + bResInt);
//                }

                // set new color
                Color colorRes = new Color(rResInt, gResInt, bResInt);
                result.set(w, h, colorRes);

                rRes = 0.0;
                gRes = 0.0;
                bRes = 0.0;

            }
        }
        return result;
    }

    public static Picture identity(Picture picture) {
        double[][] weights = {
                {
                        0, 0, 0
                },
                {
                        0, 1, 0
                },
                {
                        0, 0, 0
                }
        };
        return kernel(picture, weights);
    }

    public static Picture gaussian(Picture picture) {
        double[][] weights = {
                {
                        1.0 / 16.0, 2.0 / 16.0, 1.0 / 16.0
                },
                {
                        2.0 / 16.0, 4.0 / 16.0, 2.0 / 16.0
                },
                {
                        1.0 / 16.0, 2.0 / 16.0, 1.0 / 16.0
                }
        };

        return kernel(picture, weights);
    }

    public static Picture sharpen(Picture picture) {
        double[][] weights = {
                {
                        0, -1, 0
                },
                {
                        -1, 5, -1
                },
                {
                        0, -1, 0
                }
        };

        return kernel(picture, weights);
    }

    public static Picture laplacian(Picture picture) {
        double[][] weights = {
                {
                        -1, -1, -1
                },
                {
                        -1, 8, -1
                },
                {
                        -1, -1, -1
                }
        };

        return kernel(picture, weights);
    }

    public static Picture emboss(Picture picture) {
        double[][] weights = {
                {
                        -2, -1, 0
                },
                {
                        -1, 1, 1
                },
                {
                        0, 1, 2
                }
        };

        return kernel(picture, weights);
    }

    public static Picture motionBlur(Picture picture) {
        double[][] weights = new double[9][9];
        for (int i = 0; i < 9; i++) {
            weights[i][i] = 1.0 / 9.0;
        }
        return kernel(picture, weights);
    }

    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        // identity kernel;
        Picture pictureIdentity = identity(picture);
        pictureIdentity.show();
        // gaussian kernel
        Picture pictureGaussian = gaussian(picture);
        pictureGaussian.show();
        // sharpen kernel
        Picture pictureSharpen = sharpen(picture);
        pictureSharpen.show();
        // laplacian kernel
        Picture pictureLaplacian = laplacian(picture);
        pictureLaplacian.show();
        // emboss kernel
        Picture pictureEmboss = emboss(picture);
        pictureEmboss.show();
        // emboss kernel
        Picture pictureMotionBlur = motionBlur(picture);
        pictureMotionBlur.show();
    }
}
