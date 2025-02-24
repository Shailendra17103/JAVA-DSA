import java.util.Scanner;
class Video {
    private String title;
    private boolean checkedOut;
    private double averageRating;
    private int ratingCount;

    public Video(String title) {
        this.title = title;
        this.checkedOut = false;
        this.averageRating = 0.0;
        this.ratingCount = 0;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void checkOut() {
        if (!checkedOut) {
            checkedOut = true;
            System.out.println(title + " has been checked out.");
        } else {
            System.out.println(title + " is already checked out.");
        }
    }

    public void returnVideo() {
        if (checkedOut) {
            checkedOut = false;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " was not checked out.");
        }
    }

    public void receiveRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            averageRating = ((averageRating * ratingCount) + rating) / (++ratingCount);
            System.out.println("Rating of " + rating + " has been added to " + title + ".");
        } else {
            System.out.println("Invalid rating. Please enter a rating between 1 and 5.");
        }
    }
}

// VideoStore class to model the store
class VideoStore {
    private Video[] inventory;
    private int count;

    public VideoStore() {
        inventory = new Video[10];
        count = 0;
    }

    public void addVideo(String title) {
        if (count < inventory.length) {
            inventory[count++] = new Video(title);
            System.out.println(title + " has been added to the inventory.");
        } else {
            System.out.println("Inventory is full. Cannot add more videos.");
        }
    }

    public void checkOut(String title) {
        Video video = findVideo(title);
        if (video != null) {
            video.checkOut();
        } else {
            System.out.println("Video not found in inventory.");
        }
    }

    public void returnVideo(String title) {
        Video video = findVideo(title);
        if (video != null) {
            video.returnVideo();
        } else {
            System.out.println("Video not found in inventory.");
        }
    }

    public void receiveRating(String title, int rating) {
        Video video = findVideo(title);
        if (video != null) {
            video.receiveRating(rating);
        } else {
            System.out.println("Video not found in inventory.");
        }
    }

    public void listInventory() {
        System.out.println("Video Store Inventory:");
        for (int i = 0; i < count; i++) {
            Video video = inventory[i];
            System.out.println("Title: " + video.getTitle() +
                    ", Checked Out: " + video.isCheckedOut() +
                    ", Average Rating: " + video.getAverageRating());
        }
    }

    private Video findVideo(String title) {
        for (int i = 0; i < count; i++) {
            if (inventory[i].getTitle().equalsIgnoreCase(title)) {
                return inventory[i];
            }
        }
        return null;
    }
}

class Exp_2 {
    public static void main(String[] args) {
        VideoStore store = new VideoStore();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Video Store Menu ---");
            System.out.println("1. Add a video");
            System.out.println("2. Check out a video");
            System.out.println("3. Return a video");
            System.out.println("4. Rate a video");
            System.out.println("5. List inventory");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the video: ");
                    String addTitle = scanner.nextLine();
                    store.addVideo(addTitle);
                    break;

                case 2:
                    System.out.print("Enter the title of the video to check out: ");
                    String checkOutTitle = scanner.nextLine();
                    store.checkOut(checkOutTitle);
                    break;

                case 3:
                    System.out.print("Enter the title of the video to return: ");
                    String returnTitle = scanner.nextLine();
                    store.returnVideo(returnTitle);
                    break;

                case 4:
                    System.out.print("Enter the title of the video to rate: ");
                    String rateTitle = scanner.nextLine();
                    System.out.print("Enter the rating (1 to 5): ");
                    int rating = scanner.nextInt();
                    store.receiveRating(rateTitle, rating);
                    break;

                case 5:
                    store.listInventory();
                    break;

                case 6:
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
