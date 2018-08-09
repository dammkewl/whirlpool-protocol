package com.samourai.whirlpool.protocol;

public class WhirlpoolProtocol {

    // STOMP configuration
    public static final String SOCKET_SUBSCRIBE_USER_PRIVATE = "/private";
    public static final String SOCKET_SUBSCRIBE_USER_REPLY = "/reply";
    public static final String SOCKET_SUBSCRIBE_QUEUE = "/queue";

    // STOMP endpoints
    public static final String ENDPOINT_REGISTER_INPUT = "/registerInput";
    public static final String ENDPOINT_REVEAL_OUTPUT = "/revealOutput";
    public static final String ENDPOINT_SIGNING = "/signing";

    // REST endpoints
    public static final String ENDPOINT_POOLS = "/pools";

    /**
     * Header specifying the message type.
     */
    public static final String HEADER_MESSAGE_TYPE = "messageType";

    /**
     * Header specifying the protocol version.
     */
    public static final String HEADER_PROTOCOL_VERSION = "protocolVersion";

    /**
     * Header specifying the pool id.
     */
    public static final String HEADER_POOL_ID = "poolId";

    /**
     * Current protocol version.
     */
    public static final String PROTOCOL_VERSION = "0.3";

    public WhirlpoolProtocol() {
    }

    public static long computeInputBalanceMin(long denomination, boolean liquidity, long minerFeeMin) {
        long amount = denomination;
        if (!liquidity) {
            amount += minerFeeMin;
        }
        return amount;
    }

    public static long computeInputBalanceMax(long denomination, boolean liquidity, long minerFeeMax) {
        long amount = denomination + minerFeeMax;
        return amount;
    }
}
