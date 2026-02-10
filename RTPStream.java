public class RTPStream {
    Packet firstPacket;
    
    public RTPStream() {
        initializePackets();
    }
    
    private void initializePackets() {
        Packet packet1 = new Packet(1, "RTP Packet 1");
        Packet packet2 = new Packet(2, "RTP Packet 2");
        Packet packet3 = new Packet(3, "RTP Packet 3");
        Packet packet4 = new Packet(4, "RTP Packet 4");
        
        packet1.nextPacket = packet2;
        packet2.nextPacket = packet3;
        packet3.nextPacket = packet4;
        packet4.nextPacket = packet1;
        
        this.firstPacket = packet1;
    }
    
    public void displayPackets() {
        Packet current = firstPacket;
        for (int i = 0; i < 4; i++) {
            System.out.println("Packet " + current.sequenceNumber + ": " + new String(current.data));
            current = current.nextPacket;
        }
    }
    
    public static void main(String[] args) {
        RTPStream stream = new RTPStream();
        stream.displayPackets();
        
        System.out.println("\nCircular reference test:");
        Packet current = stream.firstPacket;
        for (int i = 0; i < 8; i++) {
            System.out.println("Step " + (i+1) + ": Packet " + current.sequenceNumber);
            current = current.nextPacket;
        }
    }
}
