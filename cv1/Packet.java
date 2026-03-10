public class Packet {
    int sequenceNumber;
    byte[] data;
    Packet nextPacket;
    
    public Packet(int sequenceNumber, String data) {
        this.sequenceNumber = sequenceNumber;
        this.data = data.getBytes();
    }
}
