package com.example.QualificationAuthenticator;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple7;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class StudentCredentials extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b604051610a44380380610a448339810160405280805182019190602001805182019190602001805182019190602001805182019190602001805182019190602001805182019190602001805160008054600160a060020a03191633600160a060020a0316179055919091019050600187805161008f929160200190610114565b5060028680516100a3929160200190610114565b5060038580516100b7929160200190610114565b5060048480516100cb929160200190610114565b5060058380516100df929160200190610114565b5060068280516100f3929160200190610114565b506007818051610107929160200190610114565b50505050505050506101af565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061015557805160ff1916838001178555610182565b82800160010185558215610182579182015b82811115610182578251825591602001919060010190610167565b5061018e929150610192565b5090565b6101ac91905b8082111561018e5760008155600101610198565b90565b610886806101be6000396000f30060606040526004361061004b5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166341c0e1b58114610050578063e3b0adf214610065575b600080fd5b341561005b57600080fd5b610063610366565b005b341561007057600080fd5b6100786103a7565b604051808060200180602001806020018060200180602001806020018060200188810388528f818151815260200191508051906020019080838360005b838110156100cd5780820151838201526020016100b5565b50505050905090810190601f1680156100fa5780820380516001836020036101000a031916815260200191505b5088810387528e818151815260200191508051906020019080838360005b83811015610130578082015183820152602001610118565b50505050905090810190601f16801561015d5780820380516001836020036101000a031916815260200191505b5088810386528d818151815260200191508051906020019080838360005b8381101561019357808201518382015260200161017b565b50505050905090810190601f1680156101c05780820380516001836020036101000a031916815260200191505b5088810385528c818151815260200191508051906020019080838360005b838110156101f65780820151838201526020016101de565b50505050905090810190601f1680156102235780820380516001836020036101000a031916815260200191505b5088810384528b818151815260200191508051906020019080838360005b83811015610259578082015183820152602001610241565b50505050905090810190601f1680156102865780820380516001836020036101000a031916815260200191505b5088810383528a818151815260200191508051906020019080838360005b838110156102bc5780820151838201526020016102a4565b50505050905090810190601f1680156102e95780820380516001836020036101000a031916815260200191505b50888103825289818151815260200191508051906020019080838360005b8381101561031f578082015183820152602001610307565b50505050905090810190601f16801561034c5780820380516001836020036101000a031916815260200191505b509e50505050505050505050505050505060405180910390f35b6000543373ffffffffffffffffffffffffffffffffffffffff908116911614156103a55760005473ffffffffffffffffffffffffffffffffffffffff16ff5b565b6103af610848565b6103b7610848565b6103bf610848565b6103c7610848565b6103cf610848565b6103d7610848565b6103df610848565b6001600260036004600560066007868054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156104825780601f1061045757610100808354040283529160200191610482565b820191906000526020600020905b81548152906001019060200180831161046557829003601f168201915b50505050509650858054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561051e5780601f106104f35761010080835404028352916020019161051e565b820191906000526020600020905b81548152906001019060200180831161050157829003601f168201915b50505050509550848054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105ba5780601f1061058f576101008083540402835291602001916105ba565b820191906000526020600020905b81548152906001019060200180831161059d57829003601f168201915b50505050509450838054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106565780601f1061062b57610100808354040283529160200191610656565b820191906000526020600020905b81548152906001019060200180831161063957829003601f168201915b50505050509350828054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106f25780601f106106c7576101008083540402835291602001916106f2565b820191906000526020600020905b8154815290600101906020018083116106d557829003601f168201915b50505050509250818054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561078e5780601f106107635761010080835404028352916020019161078e565b820191906000526020600020905b81548152906001019060200180831161077157829003601f168201915b50505050509150808054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561082a5780601f106107ff5761010080835404028352916020019161082a565b820191906000526020600020905b81548152906001019060200180831161080d57829003601f168201915b50505050509050965096509650965096509650965090919293949596565b602060405190810160405260008152905600a165627a7a72305820c506a558a6a84043d739fe5f1d207a07a33d5f7823389c340886e034f26dc9990029";

    protected StudentCredentials(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected StudentCredentials(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> kill() {
        final Function function = new Function(
                "kill", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple7<String, String, String, String, String, String, String>> returnQualification() {
        final Function function = new Function("returnQualification", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple7<String, String, String, String, String, String, String>>(
                new Callable<Tuple7<String, String, String, String, String, String, String>>() {
                    @Override
                    public Tuple7<String, String, String, String, String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<String, String, String, String, String, String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (String) results.get(6).getValue());
                    }
                });
    }

    public static RemoteCall<StudentCredentials> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _name, String _email, String _university, String _course, String _start, String _end, String _classification) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_email), 
                new org.web3j.abi.datatypes.Utf8String(_university), 
                new org.web3j.abi.datatypes.Utf8String(_course), 
                new org.web3j.abi.datatypes.Utf8String(_start), 
                new org.web3j.abi.datatypes.Utf8String(_end), 
                new org.web3j.abi.datatypes.Utf8String(_classification)));
        return deployRemoteCall(StudentCredentials.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<StudentCredentials> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _name, String _email, String _university, String _course, String _start, String _end, String _classification) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_email), 
                new org.web3j.abi.datatypes.Utf8String(_university), 
                new org.web3j.abi.datatypes.Utf8String(_course), 
                new org.web3j.abi.datatypes.Utf8String(_start), 
                new org.web3j.abi.datatypes.Utf8String(_end), 
                new org.web3j.abi.datatypes.Utf8String(_classification)));
        return deployRemoteCall(StudentCredentials.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static StudentCredentials load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new StudentCredentials(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static StudentCredentials load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new StudentCredentials(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
